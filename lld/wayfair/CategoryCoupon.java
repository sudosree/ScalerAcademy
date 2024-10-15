package lld.wayfair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryCoupon {

  static class Category {
    private String name;
    private List<Coupon> coupons;

    Category(String name, List<Coupon> coupons) {
      this.name = name;
      this.coupons = coupons;
    }
  }

  static class Coupon {
    private String name;
    private Date modifiedDate;

    Coupon(String name, Date modifiedDate) {
      this.name = name;
      this.modifiedDate = modifiedDate;
    }

    public String getName() {
      return name;
    }

    public Date getModifiedDate() {
      return modifiedDate;
    }

    @Override
    public String toString() {
      return "'" + name + "'";
    }
  }

  private static Map<String, List<Coupon>> categoryToCouponMap = new HashMap<>();
  private static Map<String, String> categoryToParentCategoryMap = new HashMap<>();
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static List<Coupon> getCouponName(final String categoryName) {
    // find the coupon corresponding to the category in the categoryToCoupon map
    // if not found then check if there exists a parent category for the given category name and check
    // if there exists a coupon for that parent category
    if (!categoryToCouponMap.containsKey(categoryName)) {
      final String parentCategoryName = findParent(categoryName);
      // check if the parent is null or not
      if (parentCategoryName.equals("None")) {
        return List.of();
      }
      List<Coupon> coupons = categoryToCouponMap.get(parentCategoryName);
      return getLatestCoupons(coupons);
    }
    return getLatestCoupons(categoryToCouponMap.get(categoryName));
  }

  private static List<Coupon> getLatestCoupons(List<Coupon> coupons) {
    // sort the coupons in descending order by their modified date
    coupons.sort((coupon1, coupon2) -> coupon2.getModifiedDate().compareTo(coupon1.getModifiedDate()));

    Date currDate = new Date();
    Date latestDate = null;
    List<Coupon> ans = new ArrayList<>();
    for (Coupon coupon : coupons) {
      // check if the modified date is in future
      if (coupon.getModifiedDate().compareTo(currDate) > 0) {
        continue;
      }
      if (latestDate == null) {
        latestDate = coupon.getModifiedDate();
        ans.add(coupon);
      }
      else if (coupon.getModifiedDate().compareTo(latestDate) == 0) {
        ans.add(coupon);
      }
    }
    return ans;
  }

  private static String findParent(final String categoryName) {
    // find the parent category of the category name, if there exists no parent of the given
    // category name then return null
    final String parentCategoryName = categoryToParentCategoryMap.get(categoryName);
    if (parentCategoryName.equals("None")) {
      return "None";
    }
    // else check if the parent category has any coupon then return the parent category
    if (categoryToCouponMap.containsKey(parentCategoryName)) {
      return parentCategoryName;
    }
    // else if the parent category has no coupon associated with it then check if any of its parents
    // has a coupon and set that parent as a parent to this category
    categoryToParentCategoryMap.put(categoryName, findParent(parentCategoryName));
    return categoryToParentCategoryMap.get(categoryName);
  }

  private static String parse(String name) {
    return name.split(":")[1];
  }

  private static void mapCategoryToCoupon(List<String[]> categoryCouponsList)
      throws ParseException {
    for (String[] categoryCoupons : categoryCouponsList) {
      String categoryName = parse(categoryCoupons[0]);
      String couponName = parse(categoryCoupons[1]);
      String modifiedDate = parse(categoryCoupons[2]);
      if (!categoryToCouponMap.containsKey(categoryName)) {
        categoryToCouponMap.put(categoryName, new ArrayList<>());
      }
      categoryToCouponMap.get(categoryName).add(new Coupon(couponName, simpleDateFormat.parse(modifiedDate)));
    }
  }

  private static void mapCategoryToParentCategory(List<String[]> categoryParentList) {
    for (String[] categoryParents : categoryParentList) {
      String categoryName = parse(categoryParents[0]);
      String parentCategoryName = parse(categoryParents[1]);
      categoryToParentCategoryMap.put(categoryName, parentCategoryName);
    }
  }

  public static void main(String[] args) throws ParseException {
    List<String[]> categoryToCouponsList = List.of(
        new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01"},
        new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01"},
        new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01"},
        new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01" },
        new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01"},
        new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01"},
        new String[]{"CategoryName:Bed & Bath", "CouponName:Big Savings for Bed & Bath", "DateModified:2030-01-01"}
    );

    List<String[]> categoryToParentCategoryList = List.of(
        new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
        new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
        new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
        new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
        new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
        new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
        new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
    );

    mapCategoryToCoupon(categoryToCouponsList);
    mapCategoryToParentCategory(categoryToParentCategoryList);

    System.out.println("Comforter Sets -> " + Arrays.toString(getCouponName("Comforter Sets").toArray()));
    System.out.println("Bedding -> " + Arrays.toString(getCouponName("Bedding").toArray()));
    System.out.println("Bathroom Accessories -> " + Arrays.toString(getCouponName("Bathroom Accessories").toArray()));
    System.out.println("Bed & Bath -> " + Arrays.toString(getCouponName("Bed & Bath").toArray()));
    System.out.println("Soap Dispensers -> " + Arrays.toString(getCouponName("Soap Dispensers").toArray()));
    System.out.println("Toy Organizers -> " + Arrays.toString(getCouponName("Toy Organizers").toArray()));
  }

}
