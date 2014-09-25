/**
 *
 */
package cs544.letmegiveexam.ws;

import cs544.letmegiveexam.dao.QuestionDAO;
import cs544.letmegiveexam.model.Question;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ObinnaKalu
 *
 */
@Controller
@RequestMapping("/rest/questions/id") // e.g http://localhost:8080/LetMeGiveExam/rest/questions/1
public class RestQuestionController {

    @Resource
    QuestionDAO questionDAO;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Question> getQuestionsBySubId(@PathVariable long id) {
        return questionDAO.getQuestionsBySubjectId(id);
    }
}
