package me.leig.tools.scheduling;

import me.leig.tools.beans.CourseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leig
 */
public class ExecutorChain {

    public List<Executor> mExecutors = new ArrayList<Executor>();

    public ExecutorChain addExecuter(Executor executor) {
        mExecutors.add(executor);
        return this;
    }

    public List<CourseBean> doChainExecuter(List<CourseBean> cours) {
        for (Executor executor : mExecutors) {
            cours = executor.doExecute(cours);
        }
        return cours;
    }
}
