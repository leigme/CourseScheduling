package me.leig.tools.beans;

import java.util.Date;

/**
 * @author leig
 */
public class Course {

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
    private Classinfo mClassinfo;
    // 教室信息
    private Classroom mClassroom;
    // 教师信息
    private Teacher mTeacher;

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

    public Classinfo getClassinfo() {
        return mClassinfo;
    }

    public void setClassinfo(Classinfo classinfo) {
        mClassinfo = classinfo;
    }

    public Classroom getClassroom() {
        return mClassroom;
    }

    public void setClassroom(Classroom classroom) {
        mClassroom = classroom;
    }

    public Teacher getTeacher() {
        return mTeacher;
    }

    public void setTeacher(Teacher teacher) {
        mTeacher = teacher;
    }
}
