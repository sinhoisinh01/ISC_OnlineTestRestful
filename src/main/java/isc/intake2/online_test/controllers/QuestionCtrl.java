package isc.intake2.online_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isc.intake2.online_test.entities.AnswerType;
import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.entities.Question;
import isc.intake2.online_test.services.AnswerTypeServiceImpl;
import isc.intake2.online_test.services.PartServiceImpl;
import isc.intake2.online_test.services.QuestionServiceImpl;

@RestController
@RequestMapping(
		produces={"application/json; charset=UTF-8"}
	)
public class QuestionCtrl implements IUrlCtrl  {
	
	@Autowired
	private AnswerTypeServiceImpl answearTypeService;
	
	@Autowired
	private PartServiceImpl partService;
	
	@Autowired
	QuestionServiceImpl questionService;
	
	@RequestMapping(value = getQuestion ,method = RequestMethod.GET)
	public ResponseEntity<List<Question>> get() {
		List<Question> questions = questionService.findAllQuestions();
		if (questions.isEmpty()) {
			return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = getQuestionById,
			method = RequestMethod.GET
		)
		public ResponseEntity<Question> get(@PathVariable("id") long id) {
		Question question = questionService.findById(id);
			if (question == null) {
				return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		}
	
	@RequestMapping(value = createQuestion, method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Question question,
    								@PathVariable("partId") long partId,
    								@PathVariable("answerTypeId") long answerTypeId,
    										UriComponentsBuilder ucBuilder) {
        Part part = partService.findById(partId);
        AnswerType ans = answearTypeService.findById(answerTypeId);
        
        //AnswerType anstypr = new AnswerType(ans.getId(), ans.getAnstId(), ans.getAnstName(), ans.getAnstOrder(), ans.getAnstSample());
        
		Question newQuestion = new Question();
		newQuestion.setQueContent(question.getQueContent());
		newQuestion.setQueIsshuffle(question.getQueIsshuffle());
		newQuestion.setQueScore(question.getQueScore());
		newQuestion.setQueOpt_Column(question.getQueOpt_Column());
		newQuestion.setQueIsBank(question.getQueIsBank());
		newQuestion.setQueLevel(question.getQueLevel());
		newQuestion.setQueMedia(question.getQueMedia());
		newQuestion.setQueReference(question.getQueReference());
		newQuestion.setQueOrder(question.getQueOrder());
		newQuestion.setPart(part);
		newQuestion.setAnswerType(ans);
		
        questionService.saveQuestion(newQuestion);
        System.out.print("test la" + newQuestion.getPart() + "answaer la !!!" + newQuestion.getAnswerType().getAnstId() + newQuestion.getAnswerType().getAnstName());
        System.out.print("test la" + newQuestion.getPart() + "answaer la !!!" + newQuestion.getAnswerType().getAnstId() + newQuestion.getAnswerType().getAnstName());

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = updateQuestion, method = RequestMethod.PUT)
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") long id, @RequestBody Question question) {
        
        Question currentQuestion = questionService.findById(id);
     
        if (currentQuestion==null) {
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
  		}
  		    
        
        questionService.saveOrUpdateQuestion(question);
        return new ResponseEntity<Question>(HttpStatus.OK);
    }
	
	
	@RequestMapping(value = deleteQuestion, method = RequestMethod.DELETE)
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") long id) {
  
        Question question = questionService.findById(id);
        if (question == null) {
           
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }
  
        questionService.deleteQuestion(questionService.findById(id));
        return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value = getQuestionByPartId, method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getQuestionByPartId(@PathVariable("part_id") long part_id) {
        return new ResponseEntity<List<Question>>(questionService.findAllQuestionsByPartId(part_id), HttpStatus.OK);
    }
	
}
