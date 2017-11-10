package me.leig.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.leig.tools.beans.Course;
import me.leig.tools.comm.ConfigAnalysis;
import me.leig.tools.comm.ConfigBean;
import me.leig.tools.comm.Constant;
import me.leig.tools.comm.Tools;
import me.leig.tools.scheduling.Condition;
import me.leig.tools.scheduling.CourseExecuter;
import me.leig.tools.scheduling.Executer;
import me.leig.tools.scheduling.ExecuterChain;
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
                List<Condition> conditions = new ArrayList<Condition>();

                Condition language = new Condition();

                language.setCourseId(1011);
                int[][] languagess = {{3, 4}, {}, {5, 6}, {}, {}};
                language.setIndexs(languagess);

                conditions.add(language);

                Condition english = new Condition();

                language.setCourseId(1012);
                int[][] englishss = {{1, 2}, {}, {2}, {}, {6}};
                english.setIndexs(englishss);

                conditions.add(english);

                Condition math = new Condition();

                math.setCourseId(1013);
                int[][] mathss = {{}, {1, 2}, {3}, {}, {2}};
                math.setIndexs(mathss);

                conditions.add(math);

                Condition science = new Condition();

                science.setCourseId(1014);
                int[][] sciencess = {{}, {}, {}, {}, {}};
                science.setIndexs(sciencess);

                conditions.add(science);

                Gson gson = new Gson();

                String jsonString = gson.toJson(conditions);

                Tools.serializeFile(cb.getConditionPath(), jsonString);
                return;
            }

            String jsonString = Tools.fileToString(cb.getConditionPath());

            Gson gson = new Gson();

            List<Condition> conditions = gson.fromJson(jsonString, new
                    TypeToken<List<Condition>>(){}.getType());

/*            int count = 0;

            for (Condition condition: conditions) {
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

            List<Course> courses = new ArrayList<Course>();

            // 创建一周的课程
            for (int i = 1; i <= indexs; i++) {
                for (int j = 1; j <= days; j++) {
                    Course course = new Course();
                    course.setIndexId(i);
                    course.setDayId(j);
                    courses.add(course);
                }
            }

            CourseExecuter ce = new CourseExecuter(conditions);

            ExecuterChain eChain = new ExecuterChain();

            eChain.addExecuter(ce);

            // 开始排课
            eChain.doChainExecuter(courses);

            for (Course course: courses) {
                log.info(course.getCourseId());
                log.info(course.getDayId());
                log.info(course.getIndexId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("app end...");
    }
}
