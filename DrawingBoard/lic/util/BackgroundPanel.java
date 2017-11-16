package com.lic.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * ������ӱ���ͼƬ�����
 * 
 */
public class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1L;// ���л����
	private Image image; // ����ͼ�����

	/**
	 * ��幹�췽��
	 * 
	 * @param image
	 *            -����ͼƬ����
	 */
	public BackgroundPanel(Image image) {
		super(); // ���ó���Ĺ��췽��
		this.image = image; // Ϊͼ�����ֵ

	}

	public BackgroundPanel() {
		super(); // ���ó���Ĺ��췽��
	}

	/**
	 * ��д�����������
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // ���ø���ķ���
		Graphics2D g2 = (Graphics2D) g; // ����Graphics2D����
		if (image != null) {
			int width = getWidth(); // ������Ŀ��
			int height = getHeight(); // ������ĸ߶�
			// ����ͼ��
			g2.drawImage(image, 0, 0, width, height, this);
		}
	}

	/**
	 * ���������ʾ��ͼƬ
	 * 
	 * @param image
	 *            - ��ʾ��ͼƬ
	 */
	public void setImage(Image image) {
		this.image = image;
		repaint();// �ػ����
	}
}
