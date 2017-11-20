package me.leig.tools.scheduling;

import me.leig.tools.beans.ConditionBean;
import me.leig.tools.beans.CourseBean;

import java.util.List;

/**
 * @author leig
 */
public class CourseExecutor implements Executor {

    // 条件
    private List<ConditionBean> mConditionBeans;
    // 课程计数
    private int count;

    public CourseExecutor(List<ConditionBean> conditionBeans) {
        this.mConditionBeans = conditionBeans;
        this.count = 0;
    }

    /**
     * 按传入的条件放置课程
     *
     * @param cours
     * @return
     */
    public List<CourseBean> doExecute(List<CourseBean> cours) {

        // 按初始条件优先设置课程
//        for (int i = 0; i < mConditionBeans.size(); i++) {
//            int courseId = mConditionBeans.get(i).getCourseId();
//            int[][] indexs = mConditionBeans.get(i).getIndexs();
//            for (int j = 0; j < indexs.length; j++) {
//                if (0 < indexs[j].length) {
//                    for (int k = 0; k < indexs[j].length; k++) {
//                        CourseBean courseBean = cours.get((j + 1) * (k + 1) - 1);
//                        if (0 == courseBean.getCourseId()) {
//                            cours.get((j + 1) * (k + 1) - 1).setCourseId(courseId);
//                            count += 1;
//                        }
//                    }
//                }
//            }
//        }

        // 如果课程没有添加完一周,则继续添加
        int index = 0;

        while (count < cours.size()) {
            for (CourseBean courseBean : cours) {
                // 判断添加的课程数量,添加满一周跳出循环
                if (count == cours.size()) {
                    break;
                }
                // 添加优先级较低的课程,填满其余空格
                if (0 == cours.get(index).getCourseId()) {

//                    for (ConditionBean conditionBean : mConditionBeans) {
//
//                        int indexs = 0;
//
//                        for (int[] ints: conditionBean.getIndexs()) {
//                            indexs += ints.length;
//                        }
//
//                        if (0 == indexs) {
//                            cours.get(index).setCourseId(conditionBean.getCourseId());
//                            count += 1;
//                        }
//                    }
                }
                index += 1;
            }
        }

        return cours;
    }

}
