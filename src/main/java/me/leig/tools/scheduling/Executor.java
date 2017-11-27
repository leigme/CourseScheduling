package me.leig.tools.scheduling;


import me.leig.tools.beans.CourseBean;

import java.util.List;

public interface Executor {

    List<CourseBean> doExecute(List<CourseBean> cours);

    boolean canArrange(CourseBean courseBean, List<CourseExecutor> executors);
}
