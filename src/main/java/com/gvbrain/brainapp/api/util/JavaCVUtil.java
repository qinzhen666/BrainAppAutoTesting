package com.gvbrain.brainapp.api.util;

import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.CV_TM_CCORR_NORMED;
import static org.bytedeco.opencv.global.opencv_imgproc.cvMatchTemplate;
import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvLoadImage;


public class JavaCVUtil {

    private IplImage image;

    public void load(String filename) {
        //传入需要对比的图片的路径
        image = cvLoadImage(filename);
    }

    public boolean matchTemplate(IplImage source) {
        boolean matchRes;
        IplImage result = cvCreateImage(opencv_core.cvSize(
                source.width() - this.image.width() + 1,
                source.height() - this.image.height() + 1),
                opencv_core.IPL_DEPTH_32F, 1);

        opencv_core.cvZero(result);
        cvMatchTemplate(source, this.image, result, CV_TM_CCORR_NORMED);
        /*CvPoint maxLoc = new CvPoint();
        CvPoint minLoc = new CvPoint();*/
        int[] maxLoc = new int[2];
        int[] minLoc = new int[2];
        double[] minVal = new double[2];//最小匹配度
        double[] maxVal = new double[2];//最大匹配度

        CvArr cvArr = result;
        cvMinMaxLoc(cvArr, minVal, maxVal, minLoc, maxLoc, null);
        System.out.println(maxVal[0]);
        System.out.println(minVal[0]);
        matchRes = minVal[0] == 0.8290257453918457f && maxVal[0] < 0.9615f ? true : false;
        cvReleaseImage(result);
        return matchRes;
    }


    public boolean javaCVTest(String comparisonPicPath,String  originalPicPath) {
        load(comparisonPicPath);//加载待对比的图片,此图片需要小于原图
        boolean result = matchTemplate(cvLoadImage(originalPicPath));//校验待对比图片是否存在于原图中
        if (result){//若结果匹配
            System.out.println("图片匹配成功");
            return true;
        }else {
            System.out.println("图片匹配失败");
            return false;
        }
    }
}
