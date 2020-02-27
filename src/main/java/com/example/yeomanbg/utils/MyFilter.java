package com.example.yeomanbg.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/1/10
 * @desc
 */
public class MyFilter {

    public static void main(String[] args) throws Exception {
        String f = args[0];

        File parent = new File(f);
        File[] list = parent.listFiles();


        assert list != null;
        for (File file : list) {
            MyFilter filter = new MyFilter();
            if (file.isDirectory()) {
                continue;
            }
            int[][] bi = filter.cleanAndGet(file);
            bi = filter.handlerClean(bi);
            String name = file.getName().substring(0, file.getName().indexOf("."));
            String path = f + File.separator + "png" + File.separator + name + ".png";
            String output = f + File.separator + "output" + File.separator + name + "";
            filter.createImage(bi, path);

            String cmd = "tesseract " + path + " " + output;
            DosUtil.dos(cmd);

        }
    }

    public void print(File file) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(file.getName());
        }
        int[] rgb = null;
        for (int i = 0, weight = bi.getHeight(); i < weight; i++) {
            for (int j = 0, height = bi.getWidth(); j < height; j++) {
                rgb = this.getRgb(bi.getRGB(j,i));
                if (rgb[0] > 20 || rgb[1] > 20 || rgb[2] > 20) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public BufferedImage clean(File file) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedImage binaryBufferedImage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        int[] rgb = null;
        for (int i = 0, weight = bi.getHeight(); i < weight; i++) {
            for (int j = 0, height = bi.getWidth(); j < height; j++) {
                rgb = this.getRgb(bi.getRGB(j,i));
                if (rgb[0] > 20 || rgb[1] > 20 || rgb[2] > 20) {
                    binaryBufferedImage.setRGB(j,i, 0xffffffff);
                } else {
                    binaryBufferedImage.setRGB(j,i, 0x00000000);
                }
            }
        }
        return binaryBufferedImage;
    }

    public int[][] cleanAndGet(File file) {

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        int[][] binaryBufferedImage = new int[bi.getWidth()][bi.getHeight()];
        int[] rgb = null;
        for (int i = 0, weight = bi.getHeight(); i < weight; i++) {
            for (int j = 0, height = bi.getWidth(); j < height; j++) {
                rgb = this.getRgb(bi.getRGB(j,i));
                if (rgb[0] > 20 || rgb[1] > 20 || rgb[2] > 20) {
                    binaryBufferedImage[j][i] = 0;
                } else {
                    binaryBufferedImage[j][i] = 1;
                }
            }
        }
        return binaryBufferedImage;
    }

    public int[][] handlerClean(int[][] bi) {
        return isHorizontal(bi) ? horizontal(bi) : vertical(bi);
    }

    protected int[][] horizontal(int[][] bi) {
        boolean set = false;
        for (int x = 0; x < bi.length; x++) {
            set = bi[x][0] == 1;
            for (int y = 0; y < bi[x].length; y++) {
                int pixel = bi[x][y];
                if (pixel != 0) {
                    if (set && ((x > 0 && bi[x - 1][y] == 0 && x < bi.length - 1 && bi[x + 1][y] == 0)) || x == 0 || x == bi.length - 1) {
                        pixel = 0;
                    }
                }
                bi[x][y] = pixel;
            }
        }
        return bi;
    }

    protected int[][] vertical(int[][] bi) {
        boolean set = false;
        for (int y = 0; y < bi[0].length; y++) {
            set = bi[0][y] == 1;
            for (int x = 0; x < bi.length; x++) {
                int pixel = bi[x][y];
                if (pixel != 0) {
                    if (set && ((y > 0 && bi[x][y - 1] == 0 && y < bi.length - 1 && bi[x][y - 1] == 0)) || x == 0 || x == bi.length - 1) {
                        pixel = 0;
                    }
                }
                bi[x][y] = pixel;
            }
        }
        return bi;
    }

    private boolean isHorizontal(int[][] bi) {
        boolean black = false;
        for (int i = 0;i < bi[0].length; i++) {
            if (bi[0][i] == 1) {
                black = true;
            } else if (black) {
                return true;
            }
        }
        return false;
    }

    private void print(int[][] bi) {
        int width = bi.length, height = bi[0].length;

        for (int j = 0; j < height; j++) {
            for (int[] ints : bi) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }

    }

    private void createImage(int[][] bi, String f) throws IOException {
        int width = bi.length, height = bi[0].length;
        BufferedImage binaryBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width ; i++) {
                if (bi[i][j] == 0) {
                    binaryBufferedImage.setRGB(i,j, 0xffffffff);
                } else {
                    binaryBufferedImage.setRGB(i,j, 0x00000000);
                }
            }
        }
        ImageIO.write(binaryBufferedImage, "png", new File(f));
    }

    public void getImagePixel(File file) throws Exception {
        int[] rgb = new int[3];
        BufferedImage bi = this.clean(file);
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        int pixel = 0;
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        boolean set = false;
        BufferedImage binaryBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        if (!isHorizontal(bi)) {
            for (int y = 0; y < height; y++) {
                set = bi.getRGB(0, y) != 0xffffffff;
                for (int x = 0; x < width; x++) {
                    pixel = bi.getRGB(x, y);
                    if (pixel != 0xffffffff) {
                        if (set && (y > 0 && bi.getRGB(0,y - 1) != 0xffffffff || y < height - 1 && bi.getRGB(0,y + 1) != 0xffffffff)) {
                            pixel = 0xffffffff;
                        }
                    }
                    binaryBufferedImage.setRGB(x,y, pixel);
                }
            }
        } else {
            for (int x = 0; x < width; x++) {
                set = bi.getRGB(x, 0) == 0xffffffff;
                for (int y = 0; y < height; y++) {
                    pixel = bi.getRGB(x, y);
                    if (pixel != 0xffffffff) {
                        if (set && (x > 0 && bi.getRGB(x - 1,0) != 0xffffffff || y < height - 1 && bi.getRGB(x + 1,0) != 0xffffffff)) {
                            pixel = 0xffffffff;
                        }
                    }
                    binaryBufferedImage.setRGB(x,y, pixel);
                }
            }
        }

        Random random = new Random();
        String path = file.getParentFile().getAbsolutePath() + File.separator + random.nextInt() + ".jpg";
        System.out.println(path);
        ImageIO.write(binaryBufferedImage, "jpg", new File(path));

    }

    public boolean isHorizontal(BufferedImage bi) {
        for (int i = 0, h = bi.getHeight(); i < h; i++) {
            if (bi.getRGB(i, 0) == 0xffffffff) {
                return true;
            }
        }
        return false;
    }

    public int[] getRgb(int pixel) {
        int[] rgb = new int[3];
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        return rgb;
    }

}
