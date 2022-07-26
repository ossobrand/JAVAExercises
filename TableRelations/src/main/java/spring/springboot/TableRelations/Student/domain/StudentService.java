package spring.springboot.TableRelations.Student.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Person.infraestructure.repository.jpa.PersonRepository;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.SimpleStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentInterface{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> simpleStudentOutputDTOS = new ArrayList<>();

        for (StudentEntity studentEntity : studentRepository.findAll()){
            SimpleStudentOutputDTO auxOutputDTO = new SimpleStudentOutputDTO(studentEntity);
            simpleStudentOutputDTOS.add(studentEntity);
        }

        return simpleStudentOutputDTOS;
    }

    @Override
    public StudentOutputDTO getStudentByID(int id, String outputType) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        StudentOutputDTO studentOutputDTO;

       if(outputType.equals("full"))
           studentOutputDTO = new FullStudentOutputDTO(studentEntity);
       else  studentOutputDTO = new SimpleStudentOutputDTO(studentEntity);

       return  studentOutputDTO;
    }

    @Override
    public StudentEntity postStudent(StudentInputDTO studentInputDTO) {
        //First we need to recover the PersonEntity linked to the InputDTO's personID
        PersonEntity personEntity = personRepository.findById(studentInputDTO.getPersonID()).orElse(null);

        StudentEntity studentEntity = new StudentEntity(studentInputDTO, personEntity);
        studentRepository.save(studentEntity);
        return studentEntity;
    }

    @Override
    public StudentEntity updateStudent(int id, StudentInputDTO studentInputDTO) {
        return null;
    }

    @Override
    public StudentEntity deleteStudent(int id) {
        return null;
    }
}