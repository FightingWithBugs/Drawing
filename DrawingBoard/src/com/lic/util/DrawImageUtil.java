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
 * ��ͼ������
 * 
 */
public class DrawImageUtil {
    /**
     * ���ļ����洰�ڣ�����ǰ��ͼ���浽����
     * 
     * @param frame
     *            - ���ô˹��ܵĴ���
     * @param saveImage
     *            - �����ͼƬ
     */
    public static void saveImage(JFrame frame, BufferedImage saveImage) {
        JFileChooser jfc = new JFileChooser();// �����ļ�������
        jfc.setDialogTitle("����ͼƬ");// �����ļ�ѡ��������
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG",
                "jpg");// �����ļ���������ֻ��ʾ.jpg��׺��ͼƬ
        jfc.setFileFilter(filter);// �ļ�ѡ����ʹ�ù�����
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");// �������ڸ�ʽ����
        String fileName = sdf.format(new Date());// ����ǰ������Ϊ�ļ���
        FileSystemView view = FileSystemView.getFileSystemView();// ��ȡϵͳ�ļ���ͼ��
        File filePath = view.getHomeDirectory();// ��ȡ����·��
        File showFile = new File(filePath, fileName + ".jpg");// ����Ҫ�ļ�ѡ����Ĭ�ϴ򿪵��ļ�
        jfc.setSelectedFile(showFile);// ���ļ�ѡ������Ĭ��ѡ���ļ���ΪsaveFile
        int flag = jfc.showSaveDialog(null);// ���������е����ļ�ѡ��������ȡ�û�������
        if (flag == JFileChooser.APPROVE_OPTION) {// ���ѡ�е��Ǳ��水ť
            try {
                File saveFile = jfc.getSelectedFile();// ��ȡ�ļ�ѡ����ѡ����ļ�
                if (saveFile == null) {//����ļ���null
                    throw new IOException();//�׳��쳣
                }else{
                    ImageIO.write(saveImage, "jpg", saveFile);// ����jpg��ʽ��ͼƬ�ļ�
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "�ļ��޷����棡", "����",
                        JOptionPane.ERROR);
            }
        }
    }
}
