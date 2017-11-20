package me.leig.tools.beans;

import java.util.Date;

/**
 * 课程单元
 *
 * @author leig
 */
public class CourseBean {

    // 学期
    private int termId;
    // 周次
    private int weekId;
    // 星期
    private int dayId;
    // 节次
    private int indexId;
    // 日期
    private Date dateTime;
    // 科目编号
    private int courseId;
    // 科目标题
    private String courseTitle;
    // 班级信息
    private ClassinfoBean mClassinfoBean;
    // 教室信息
    private ClassroomBean mClassroomBean;
    // 教师信息
    private TeacherBean mTeacherBean;
    // 预计优先节次
    private int[] indexIds;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public ClassinfoBean getmClassinfoBean() {
        return mClassinfoBean;
    }

    public void setmClassinfoBean(ClassinfoBean mClassinfoBean) {
        this.mClassinfoBean = mClassinfoBean;
    }

    public ClassroomBean getmClassroomBean() {
        return mClassroomBean;
    }

    public void setmClassroomBean(ClassroomBean mClassroomBean) {
        this.mClassroomBean = mClassroomBean;
    }

    public TeacherBean getmTeacherBean() {
        return mTeacherBean;
    }

    public void setmTeacherBean(TeacherBean mTeacherBean) {
        this.mTeacherBean = mTeacherBean;
    }

    public int[] getIndexIds() {
        return indexIds;
    }

    public void setIndexIds(int[] indexIds) {
        this.indexIds = indexIds;
    }
}
