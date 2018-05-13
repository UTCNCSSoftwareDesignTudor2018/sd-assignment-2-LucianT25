import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';
import {HttpHeaders} from '@angular/common/http';
import { Response } from '@angular/http';

interface Enrollment {
  course : Course;
  student : Student;
  grade : number;
}
interface Course {
  id : number;
  name : string;
  year : number;
  credits : number;
}
interface Student {
  id : number;
  name : string;
  address : string;
  email : string;
  year : number;
  pnc : number;
}
interface Teacher {
  id : number;
  name : string;
  address : string;
  email : string;
  course : Course;
}
interface Report {
  id : number;
  student : Student;
  enrollments : Enrollment[]
}

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.scss']
})
export class TeacherComponent implements OnInit {

  generateText : string = "Generate Report";
  gradeText : string = "Update Grade";
  userId : number;
  course : Course;
  itemCount : number;
  idToReport : number;
  yearOfStudy : number;
  enrollmentResponse : Enrollment[];
  enrollments : Enrollment[];
  grade : number;
  studentIdreport : string;
  studentIdgrading : string;

  constructor(
    private route: ActivatedRoute, private router : Router,
    private httpClient : HttpClient,
    ) {
      this.route.params.subscribe(res => this.userId = res.id);
      console.log(this.userId);
    }

  ngOnInit() {
    this.httpClient.get('http://localhost:8080/teacher/getEnrolledStudents?teacherId='+this.userId)
    .subscribe(data =>{this.enrollmentResponse = data as Enrollment[],
       this.itemCount = this.enrollmentResponse.length,
       this.course = this.enrollmentResponse[0].course},
          err => console.error(err),
          () => console.log(this.enrollmentResponse)
        );
    this.enrollments = this.enrollmentResponse;
   
  }

  generateReport() {
    var toGenerate = JSON.stringify({studentId:this.studentIdreport, year:this.yearOfStudy});
    console.log(toGenerate);

    let headers = new HttpHeaders();
    headers.set('Accept', 'application/json').set('Content-Type', 'application/json');
    console.log(headers);

    this.httpClient.post<Report>('http://localhost:8080/report/create', toGenerate, {headers : headers}).subscribe();
  }

  updateGrade() {
    var toUpdate = JSON.stringify({studentId:this.studentIdgrading, courseId:this.course.id, grade:this.grade});
    console.log(toUpdate);

    let headers = new HttpHeaders();
    headers.set('Accept', 'application/json').set('Content-Type', 'application/json');
    console.log(headers);

    this.httpClient.post<Enrollment>('http://localhost:8080/enrollment/updateGrade', toUpdate, {headers : headers}).subscribe();
  }
}