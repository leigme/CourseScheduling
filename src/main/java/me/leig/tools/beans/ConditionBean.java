package me.leig.tools.beans;

import java.util.List;

/**
 * 排课条件对象
 *
 * @author leig
 */
public class ConditionBean {

    private int classId;

    private List<CourseBean> courseBeans;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<CourseBean> getCourseBeans() {
        return courseBeans;
    }

    public void setCourseBeans(List<CourseBean> courseBeans) {
        this.courseBeans = courseBeans;
    }
}
