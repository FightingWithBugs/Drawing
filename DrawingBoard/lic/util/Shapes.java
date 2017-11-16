package com.lic.util;

/**
 * ͼ��ѡ��������ص�ͼ����
 * 
 */
public class Shapes {
	/**
	 * Բ��
	 */
	public static final int YUAN = 0x6321;
	/**
	 * ����
	 */
	public static final int FANG = 0x6425;
	private int type;// ͼ������
	private int width;// ͼ�ο��
	private int height;// ͼ�θ߶�

	/**
	 * ����ͼ�ζ���
	 */
	public Shapes() {
		super();
	}

	/**
	 * ����ͼ�ζ���
	 * 
	 * @param type
	 *            - ͼ������
	 * @param width
	 *            - ͼ�ο��
	 * @param height
	 *            - ͼ�θ߶�
	 */
	public Shapes(int type, int width, int height) {
		super();
		this.type = type;
		this.width = width;
		this.height = height;
	}

	/**
	 * ��ȡͼ������
	 * 
	 * @return ͼ������
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * ��ȡͼ�ο��
	 * 
	 * @return ͼ�ο��
	 */
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return height;
	}

	/**
	 * ��ȡͼ�θ߶�
	 * 
	 * @param height
	 *            ͼ�θ߶�
	 */
	public void setHeigth(int height) {
		this.height = height;
	}

	/**
	 * ��������ַ�����ʾ��ʽ
	 */
	public String toString() {
		return "Shapes [type=" + type + ", width=" + width + ", height="
				+ height + "]";
	}

}
