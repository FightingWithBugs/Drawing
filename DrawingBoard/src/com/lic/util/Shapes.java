package com.lic.util;

/**
 * 图形选择组件返回的图形类
 * 
 */
public class Shapes {
	/**
	 * 圆形
	 */
	public static final int YUAN = 0x6321;
	/**
	 * 方形
	 */
	public static final int FANG = 0x6425;
	private int type;// 图形种类
	private int width;// 图形宽度
	private int height;// 图形高度

	/**
	 * 创建图形对象
	 */
	public Shapes() {
		super();
	}

	/**
	 * 创建图形对象
	 * 
	 * @param type
	 *            - 图形种类
	 * @param width
	 *            - 图形宽度
	 * @param height
	 *            - 图形高度
	 */
	public Shapes(int type, int width, int height) {
		super();
		this.type = type;
		this.width = width;
		this.height = height;
	}

	/**
	 * 获取图形种类
	 * 
	 * @return 图形种类
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 获取图形宽度
	 * 
	 * @return 图形宽度
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
	 * 获取图形高度
	 * 
	 * @param height
	 *            图形高度
	 */
	public void setHeigth(int height) {
		this.height = height;
	}

	/**
	 * 返回类的字符串表示形式
	 */
	public String toString() {
		return "Shapes [type=" + type + ", width=" + width + ", height="
				+ height + "]";
	}

}
