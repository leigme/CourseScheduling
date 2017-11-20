package me.leig.tools;

import me.leig.tools.beans.CourseBean;
import me.leig.tools.comm.ConfigAnalysis;
import me.leig.tools.comm.ConfigBean;
import me.leig.tools.comm.Constant;
import me.leig.tools.beans.ConditionBean;
import me.leig.tools.scheduling.CourseExecutor;
import me.leig.tools.scheduling.ExecutorChain;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger log = Logger.getLogger(App.class);

    private static int days = 5;

    private static int indexs = 8;

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        log.info("app start...");

        ConfigAnalysis configAnalysis = new ConfigAnalysis(Constant.CONFIGPATH);

        try {
            ConfigBean cb = configAnalysis.startAnalysis();

            if (cb.isDebug()) {
//                List<ConditionBean> conditionBeans = new ArrayList<ConditionBean>();
//
//                ConditionBean language = new ConditionBean();
//
//                language.setCourseId(1011);
//                int[][] languagess = {{3, 4}, {}, {5, 6}, {}, {}};
//                language.setIndexs(languagess);
//
//                conditionBeans.add(language);
//
//                ConditionBean english = new ConditionBean();
//
//                language.setCourseId(1012);
//                int[][] englishss = {{1, 2}, {}, {2}, {}, {6}};
//                english.setIndexs(englishss);
//
//                conditionBeans.add(english);
//
//                ConditionBean math = new ConditionBean();
//
//                math.setCourseId(1013);
//                int[][] mathss = {{}, {1, 2}, {3}, {}, {2}};
//                math.setIndexs(mathss);
//
//                conditionBeans.add(math);
//
//                ConditionBean science = new ConditionBean();
//
//                science.setCourseId(1014);
//                int[][] sciencess = {{}, {}, {}, {}, {}};
//                science.setIndexs(sciencess);
//
//                conditionBeans.add(science);
//
//                Gson gson = new Gson();
//
//                String jsonString = gson.toJson(conditionBeans);
//
//                Tools.serializeFile(cb.getConditionPath(), jsonString);
                return;
            }

//            String jsonString = Tools.fileToString(cb.getConditionPath());
//
//            Gson gson = new Gson();
//
//            List<ConditionBean> conditionBeans = gson.fromJson(jsonString, new
//                    TypeToken<List<ConditionBean>>(){}.getType());

/*            int count = 0;

            for (ConditionBean condition: conditionBeans) {
                int[][] intss = condition.getIndexs();
                for (int[] ints: intss) {
                    for (int i: ints) {
                        count += 1;
                    }
                }
            }

            // 验证课程数量是否满足一周课程安排
            if (indexs * days > count) {
                log.error("一周课时安排少于[" + indexs * days + "]课,请重新设置条件!");
                return;
            }*/

            List<ConditionBean> conditionBeans = new ArrayList<>();

            List<CourseBean> courses = new ArrayList<>();

            // 创建一周的课程格子
            for (int i = 1; i <= indexs; i++) {
                for (int j = 1; j <= days; j++) {
                    CourseBean courseBean = new CourseBean();
                    courseBean.setIndexId(i);
                    courseBean.setDayId(j);
                    courses.add(courseBean);
                }
            }

            // 排课班级数
            // 排课课程数

            CourseExecutor ce = new CourseExecutor(conditionBeans);

            ExecutorChain eChain = new ExecutorChain();

            eChain.addExecuter(ce);

            // 开始排课
            eChain.doChainExecuter(courses);

            for (CourseBean courseBean : courses) {
                log.info(courseBean.getCourseId());
                log.info(courseBean.getDayId());
                log.info(courseBean.getIndexId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("app end...");
    }
}
