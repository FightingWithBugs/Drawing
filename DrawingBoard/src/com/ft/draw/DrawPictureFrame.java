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
 * ����һ������  �������߸���ť
 *
 */
class DrawFrame extends JFrame {
	public void CreateFrame(String title) {
//		����jf
		JFrame jf = new JFrame(title);
		jf.setVisible(true);
		jf.setSize(500,500);
//		������������ӵ�����
		Container c = jf.getContentPane();
//		���ò��ֹ�����
		c.setLayout(new FlowLayout(10,10,10));
		
//		������ť
		Button save = new Button("����");
		Button thickLine = new Button("ϸ��");
		Button fineLine = new Button("����");
		Button backgroundColor = new Button("������ɫ");
		Button foregroundColor = new Button("ǰ����ɫ");
		Button cleanPicture = new Button("���ͼƬ");
		Button rubber = new Button("��Ƥ");
//		��ť��ӵ�����
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
 * ������
 *
 */
class Monitor extends MouseAdapter {
	public void mouse (MouseEvent e) {
		
	}
}

