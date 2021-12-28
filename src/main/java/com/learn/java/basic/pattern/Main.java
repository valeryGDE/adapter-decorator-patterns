package com.learn.java.basic.pattern;

import com.learn.java.basic.pattern.extra.Rhombus;
import com.learn.java.basic.pattern.extra.Triangle;

public class Main {

    public static void main(String[] args) {

        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new GeometricShapeObjectAdapter(new Triangle()));
        drawing.addShape(new GeometricShapeObjectAdapter(new Rhombus()));

        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();

        System.out.println("Creating Decorated Circle with Red Color, Blue Lines in dash pattern and thickness of 2 ...");
        Shape circle1 = new FillColorDecorator(new LineColorDecorator(new LineStyleDecorator(
                new LineThicknessDecorator(new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
        circle1.draw();
        System.out.println();

        System.out.println("creating object with similar functionalities in separate statements.");
        Circle c = new Circle();
        LineThicknessDecorator lt = new LineThicknessDecorator(c, 2.0d);
        LineStyleDecorator ls = new LineStyleDecorator(lt, LineStyle.DASH);
        LineColorDecorator lc = new LineColorDecorator(ls, Color.BLUE);
        FillColorDecorator fc = new FillColorDecorator(lc, Color.RED);
        Shape circle3 = fc;
        circle3.draw();
        System.out.println();

        System.out.println("Creating Decorated Circle with Green Color, Black Lines ...");
        Shape circle2 = new FillColorDecorator(new LineColorDecorator(new Circle(), Color.BLACK), Color.GREEN);
        circle2.draw();
        System.out.println();

        System.out.println("Creating Decorated Rectangle with Yellow Color, Red Lines in double dash pattern...");
        Shape rectangle1 = new FillColorDecorator(new LineColorDecorator(new Rectangle(), Color.RED), Color.YELLOW);
        rectangle1.draw();
        System.out.println();


        System.out.println("Creating Decorated Triangle with White Color, Orange Lines ...");
        Shape triangle1 = new FillColorDecorator(new LineColorDecorator(new GeometricShapeObjectAdapter(new Triangle()), Color.WHITE), Color.ORANGE);
        triangle1.draw();
        System.out.println();

        System.out.println("Creating Decorated Rhombus with Maroon Color, Red Lines in double dash pattern...");
        Shape rhombus1 = new FillColorDecorator(new LineColorDecorator(new GeometricShapeObjectAdapter(new Rhombus()), Color.MAROON), Color.YELLOW);
        rhombus1.draw();
        System.out.println();

    }
}
