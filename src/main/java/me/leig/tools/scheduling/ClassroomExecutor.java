package me.leig.tools.scheduling;

import me.leig.tools.beans.CourseBean;

import java.util.List;

/**
 * @author leig
 */
public class ClassroomExecutor implements Executor {

    @Override
    public List<CourseBean> doExecute(List<CourseBean> cours) {
        return cours;
    }

    @Override
    public boolean canArrange(CourseBean courseBean, List<CourseExecutor> executors) {
        return false;
    }
}
