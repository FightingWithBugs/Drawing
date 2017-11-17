package com.ft.draw;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DrawPictureFrame {
	public static void main(String[] args) {
		new DrawFrame().CreateFrame("draw");
	}
}

/**
 * 
 * 创建一个窗体  里面有七个按钮
 *
 */
class DrawFrame extends JFrame {
	public void CreateFrame(String title) {
//		窗体jf
		JFrame jf = new JFrame(title);
		jf.setVisible(true);
		jf.setSize(500,500);
//		设置容器并添加到窗体
		Container c = jf.getContentPane();
//		设置布局管理器
		c.setLayout(new FlowLayout(10,10,10));
		
//		创建按钮
		Button save = new Button("保存");
		Button thickLine = new Button("细线");
		Button fineLine = new Button("粗线");
		Button backgroundColor = new Button("背景颜色");
		Button foregroundColor = new Button("前景颜色");
		Button cleanPicture = new Button("清除图片");
		Button rubber = new Button("橡皮");
//		按钮添加到容器
		c.add(save);
		c.add(thickLine);
		c.add(fineLine);
		c.add(backgroundColor);
		c.add(foregroundColor);
		c.add(cleanPicture);
		c.add(rubber);
		
	}
		
	
}

/**
 * 
 * 鼠标监听
 *
 */
class Monitor extends MouseAdapter {
	public void mouse (MouseEvent e) {
		
	}
}

