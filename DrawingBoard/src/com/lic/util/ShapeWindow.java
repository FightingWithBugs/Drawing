package com.lic.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JWindow;

/**
 * 图形选择组件
 * 
 */
public class ShapeWindow extends JWindow {
	private Shapes shapes;
	private FrameGetShape frame;

	/**
	 * 图形选择组件
	 * 
	 * @param frame
	 *            - 获取组件返回结果的窗体
	 */
	public ShapeWindow(FrameGetShape frame) {
		this.frame = frame;
		init();
	}

	/**
	 * 图形选择组件
	 * 
	 * @param x
	 *            -组件显示的横坐标
	 * @param y
	 *            -组件显示的纵坐标
	 * @param frame
	 *            - 获取组件返回结果的窗体
	 */
	public ShapeWindow(int x, int y, FrameGetShape frame) {
		this.frame = frame;
		setLocation(x, y);
		init();
	}

	/**
	 * 组件初始化
	 */
	private void init() {
		setSize(200, 100);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();

		Ellipse2D e = new Ellipse2D.Double(0, 0, 14, 14);
		ShapeButton yuan = new ShapeButton(e);
		centerPanel.add(yuan);

		Rectangle2D r = new Rectangle2D.Double(0, 0, 14, 14);
		ShapeButton fang = new ShapeButton(r);
		centerPanel.add(fang);

		c.add(centerPanel, BorderLayout.CENTER);

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		southPanel.setLayout(flow);
		JButton cancel = new JButton("取消");
		southPanel.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		c.add(southPanel, BorderLayout.SOUTH);
		pack();
	}

	/**
	 * 内部类：自定义面板，包含一个按钮，两个微调框。
	 * 
	 *
	 */
	class ShapeButton extends JPanel {
		public ShapeButton(final Shape shape) {
			setSize(20, 20);
			setLayout(new BorderLayout());

			BufferedImage img = new BufferedImage(15, 15,
					BufferedImage.TYPE_INT_BGR);
			Graphics2D g = img.createGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, img.getWidth(), img.getHeight());
			g.setColor(Color.BLACK);
			g.draw(shape);

			JButton btnNewButton = new JButton();
			btnNewButton.setIcon(new ImageIcon(img));
			JPanel p = new JPanel();
			p.add(btnNewButton);
			add(p, BorderLayout.CENTER);

			JPanel south = new JPanel();
			south.setLayout(new FlowLayout());

			final JSpinner spinnerLeft = new JSpinner();// 微调框
			spinnerLeft.setValue(50);
			south.add(new JLabel("宽"));
			south.add(spinnerLeft);

			final JSpinner spinnerRigth = new JSpinner();// 微调框
			spinnerRigth.setValue(50);
			south.add(new JLabel("高"));
			south.add(spinnerRigth);

			add(south, BorderLayout.SOUTH);

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (shape instanceof Ellipse2D) {// 如果是圆形
						shapes = new Shapes(Shapes.YUAN, (Integer) spinnerLeft
								.getValue(), (Integer) spinnerRigth.getValue());
					}
					if (shape instanceof Rectangle2D) {// 如果是矩形
						shapes = new Shapes(Shapes.FANG, (Integer) spinnerLeft
								.getValue(), (Integer) spinnerRigth.getValue());
					}
					frame.getShape(shapes);// 将结果反馈给调用窗体
					dispose();// 销毁窗体
				}
			});
		}
	}
}
