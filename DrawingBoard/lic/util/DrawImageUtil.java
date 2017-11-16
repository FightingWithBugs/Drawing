package com.lic.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * 绘图工具类
 * 
 */
public class DrawImageUtil {
    /**
     * 打开文件保存窗口，将当前截图保存到本地
     * 
     * @param frame
     *            - 调用此功能的窗体
     * @param saveImage
     *            - 保存的图片
     */
    public static void saveImage(JFrame frame, BufferedImage saveImage) {
        JFileChooser jfc = new JFileChooser();// 创建文件过滤器
        jfc.setDialogTitle("保存图片");// 设置文件选择器标题
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG",
                "jpg");// 创建文件过滤器，只显示.jpg后缀的图片
        jfc.setFileFilter(filter);// 文件选择器使用过滤器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");// 创建日期格式化类
        String fileName = sdf.format(new Date());// 将当前日期作为文件名
        FileSystemView view = FileSystemView.getFileSystemView();// 获取系统文件视图类
        File filePath = view.getHomeDirectory();// 获取桌面路径
        File showFile = new File(filePath, fileName + ".jpg");// 创建要文件选择器默认打开的文件
        jfc.setSelectedFile(showFile);// 将文件选择器的默认选中文件设为saveFile
        int flag = jfc.showSaveDialog(null);// 在主窗体中弹出文件选择器，获取用户操作码
        if (flag == JFileChooser.APPROVE_OPTION) {// 如果选中的是保存按钮
            try {
                File saveFile = jfc.getSelectedFile();// 获取文件选择器选择的文件
                if (saveFile == null) {//如果文件是null
                    throw new IOException();//抛出异常
                }else{
                    ImageIO.write(saveImage, "jpg", saveFile);// 生成jpg格式的图片文件
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "文件无法保存！", "错误",
                        JOptionPane.ERROR);
            }
        }
    }
}
