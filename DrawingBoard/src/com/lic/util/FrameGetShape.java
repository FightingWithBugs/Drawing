package com.lic.util;

/**
 * 兼容图形选择组件接口。实现该接口之后，可在getShape(Shapes shape)方法中获得组件返回的图形对象。
 * 
 */
public interface FrameGetShape {
	/**
	 * 获取图形选择组件选中的图形
	 * 
	 * @param shape
	 *            - 被图形选择组件选中的图形
	 */
	public void getShape(Shapes shape);
}
