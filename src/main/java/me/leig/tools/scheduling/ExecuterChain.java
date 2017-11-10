package me.leig.tools.scheduling;

import me.leig.tools.beans.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leig
 */
public class ExecuterChain {

    public List<Executer> mExecuters = new ArrayList<Executer>();

    public ExecuterChain addExecuter(Executer executer) {
        mExecuters.add(executer);
        return this;
    }

    public List<Course> doChainExecuter(List<Course> courses) {
        for (Executer executer: mExecuters) {
            courses = executer.doExecute(courses);
        }
        return courses;
    }
}
