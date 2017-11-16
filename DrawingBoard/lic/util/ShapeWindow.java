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
 * ͼ��ѡ�����
 * 
 */
public class ShapeWindow extends JWindow {
	private Shapes shapes;
	private FrameGetShape frame;

	/**
	 * ͼ��ѡ�����
	 * 
	 * @param frame
	 *            - ��ȡ������ؽ���Ĵ���
	 */
	public ShapeWindow(FrameGetShape frame) {
		this.frame = frame;
		init();
	}

	/**
	 * ͼ��ѡ�����
	 * 
	 * @param x
	 *            -�����ʾ�ĺ�����
	 * @param y
	 *            -�����ʾ��������
	 * @param frame
	 *            - ��ȡ������ؽ���Ĵ���
	 */
	public ShapeWindow(int x, int y, FrameGetShape frame) {
		this.frame = frame;
		setLocation(x, y);
		init();
	}

	/**
	 * �����ʼ��
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
		JButton cancel = new JButton("ȡ��");
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
	 * �ڲ��ࣺ�Զ�����壬����һ����ť������΢����
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

			final JSpinner spinnerLeft = new JSpinner();// ΢����
			spinnerLeft.setValue(50);
			south.add(new JLabel("��"));
			south.add(spinnerLeft);

			final JSpinner spinnerRigth = new JSpinner();// ΢����
			spinnerRigth.setValue(50);
			south.add(new JLabel("��"));
			south.add(spinnerRigth);

			add(south, BorderLayout.SOUTH);

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (shape instanceof Ellipse2D) {// �����Բ��
						shapes = new Shapes(Shapes.YUAN, (Integer) spinnerLeft
								.getValue(), (Integer) spinnerRigth.getValue());
					}
					if (shape instanceof Rectangle2D) {// ����Ǿ���
						shapes = new Shapes(Shapes.FANG, (Integer) spinnerLeft
								.getValue(), (Integer) spinnerRigth.getValue());
					}
					frame.getShape(shapes);// ��������������ô���
					dispose();// ���ٴ���
				}
			});
		}
	}
}
