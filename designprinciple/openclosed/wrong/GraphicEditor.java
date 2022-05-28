package designprinciple.openclosed.wrong;

public class GraphicEditor {

    public Shape drawShape(int type) {
        if (type == 1) {
            return drawRectangle();
        } else if (type == 2) {
            return drawCircle();
        }
        return null;
    }

    private Shape drawRectangle() {
        return new Rectangle();
    }

    private Shape drawCircle() {
        return new Circle();
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        System.out.println(editor.drawShape(1).getClass().getName());
    }
}
