package me.leig.tools.scheduling;

import me.leig.tools.beans.Course;

import java.util.List;

/**
 * @author leig
 */
public class CourseExecuter implements Executer {

    // 条件
    private List<Condition> mConditions;
    // 课程计数
    private int count;

    public CourseExecuter(List<Condition> conditions) {
        this.mConditions = conditions;
        this.count = 0;
    }

    /**
     * 按传入的条件放置课程
     *
     * @param courses
     * @return
     */
    public List<Course> doExecute(List<Course> courses) {

        // 按初始条件优先设置课程
        for (int i = 0; i < mConditions.size(); i++) {
            int courseId = mConditions.get(i).getCourseId();
            int[][] indexs = mConditions.get(i).getIndexs();
            for (int j = 0; j < indexs.length; j++) {
                if (0 < indexs[j].length) {
                    for (int k = 0; k < indexs[j].length; k++) {
                        Course course = courses.get((j + 1) * (k + 1) - 1);
                        if (0 == course.getCourseId()) {
                            courses.get((j + 1) * (k + 1) - 1).setCourseId(courseId);
                            count += 1;
                        }
                    }
                }
            }
        }

        // 如果课程没有添加完一周,则继续添加
        int index = 0;

        while (count < courses.size()) {
            for (Course course: courses) {
                // 判断添加的课程数量,添加满一周跳出循环
                if (count == courses.size()) {
                    break;
                }
                // 添加优先级较低的课程,填满其余空格
                if (0 == courses.get(index).getCourseId()) {

                    for (Condition condition: mConditions) {

                        int indexs = 0;

                        for (int[] ints: condition.getIndexs()) {
                            indexs += ints.length;
                        }

                        if (0 == indexs) {
                            courses.get(index).setCourseId(condition.getCourseId());
                            count += 1;
                        }
                    }
                }
                index += 1;
            }
        }

        return courses;
    }

}
