package main

import (
	"encoding/json"
	"fmt"
)

// Note that the Go json.Marshal() function only exports fields that start with an upper case name. 
type question struct {
	Question string
	Answers []string // The first Answer is always the correct answer.
}

type questionBank struct {
	ID string
	Name string
	Number int
	Questions []question
}

func main() {
	goBasicsQuestions()
	goTestingQuestions()
	javascriptBasicsQuestions()
}

func goBasicsQuestions() {
	var qb questionBank
	qb.ID = "x2856j"
	qb.Name = "Go Basics"
	qb.Number = 3

	addQuestion(&qb,
		"Which of the following statements relating to Go is FALSE?",
		"Go supports class Inheritance",
		"Go supports Encapsulation",
		"Go supports Interfaces",
		"Go supports Polymorphism though Interfaces",
		"Go supports Arrays")

	addQuestion(&qb,
		"Which of the following Go statements will successfully create a new variable “x” and set it to 5?",
		"x := 5",
		"x == 5",
		"x = 5",
		"let x = 5",
		"set x = 5")

	addQuestion(&qb,
		"Which of the following Go statements will successfully create a new variable “y” and set it to the integer value 10?",
		"y := 10",
		"let y = 10",
		"y = 10",
		"int y = 10",
		"set y = 10")

	json, _ := json.MarshalIndent(qb, "", "    ")
	jsonString := string(json)
	fmt.Println(jsonString)
}

func goTestingQuestions() {
	var qb questionBank
	qb.ID = "x2856k"
	qb.Name = "Go Testing"
	qb.Number = 2

	addQuestion(&qb,
		"Which of the following statements relating to automated testing and Go is true?",
		"Go supports automated testing out of the box through a standard package named “testing”",
		"Go supports automated testing only through the use of third party packages",
		"Go supports automated testing out of the box through a standard package named “validation”",
		"Go does not support automated testing",
		"Go supports automated testing only through external scripting using tools like Python")

	addQuestion(&qb,
		"To execute a series of three tests on an application named “tiger” what would we type?",
		"go test",
		"go testing",
		"./tiger test",
		"./tiger testing",
		"go tiger testing")

	json, _ := json.MarshalIndent(qb, "", "    ")
	jsonString := string(json)
	fmt.Println(jsonString)
}

func javascriptBasicsQuestions() {
	var qb questionBank
	qb.ID = "x2856m"
	qb.Name = "JavaScript Basics"
	qb.Number = 5

	addQuestion(&qb,
		"Which of the following statements relating to JavaScript running in a Web browser is FALSE? ",
		"JavaScript can be used to update a file on your hard drive",
		"JavaScript can be used to change the style of an element",
		"JavaScript can be used to add additional content to a web page",
		"JavaScript can be used to remove content from a web page",
		"JavaScript can be used to request data from a Web server")

	addQuestion(&qb,
		"Why would we create a question with 2 answers?",
		"To test true and false type quesions",
		"For the taste")

	addQuestion(&qb,
		"Why would we create a question with 3 answers?",
		"To test if it works with three answers",
		"abc (don’t pick this answer)",
		"efg (this one is wrong also")

	addQuestion(&qb,
		"Why would we create a question with 4 answers?",
		"To test if it works with four answers",
		"Answer 2 (wrong)",
		"Answer 3 (wrong)",
		"Answer 4 (wrong)")

	addQuestion(&qb,
		"Why would we create a question with 6 answers?",
		"To test if it works with four answers",
		"Answer 2 (wrong)",
		"Answer 3 (wrong)",
		"Answer 4 (wrong)",
		"Answer 5 (wrong)",
		"Answer 6 (wrong)")

	json, _ := json.MarshalIndent(qb, "", "    ")
	jsonString := string(json)
	fmt.Println(jsonString)

}




func addQuestion(qb *questionBank, questionText string, answerText ...string) {
	var q question
	q.Question = questionText
	for _, s := range answerText {
		q.Answers = append(q.Answers, s)
	}
	qb.Questions = append(qb.Questions, q)

}