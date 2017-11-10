package me.leig.tools.scheduling;


import me.leig.tools.beans.Course;

import java.util.List;

public interface Executer {

    List<Course> doExecute(List<Course> courses);

}
