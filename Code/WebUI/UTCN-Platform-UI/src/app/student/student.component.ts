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

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  userId : number;

  itemCount : number;
  enrollText : string = "Enroll";
  updateText : string = "Update";

  courseId : string = "";
  name : string = "";
  address : string = "";
  email : string = "";

  courses : Enrollment[] = [];
  coursesResponse : Enrollment[] = [];
  studentResponse : Student[] = [];

  constructor(private route: ActivatedRoute, private router : Router, private httpClient : HttpClient) {
    this.route.params.subscribe(res => this.userId = res.id);
    console.log(this.userId);
   }

  ngOnInit() {   
    this.httpClient.get('http://localhost:8080/student/getStudent?studentId='+this.userId).subscribe(data =>{this.studentResponse = data as Student[]},
          err => console.error(err),
          () => console.log(this.studentResponse)
        );
    this.httpClient.get('http://localhost:8080/enrollment/getStudentEnrollments?studentId='+this.userId)
    .subscribe(data => { this.coursesResponse = data as Enrollment[], this.itemCount = this.coursesResponse.length},
          err => console.error(err),
          () => console.log(this.coursesResponse)
        );  
    //this.itemCount = this.courses.length;
    }

  addItem() {
    var toEnroll = JSON.stringify({studentId:this.userId, courseId:this.courseId});
    console.log(toEnroll);

    let headers = new HttpHeaders();
    headers.set('Accept', 'application/json').set('Content-Type', 'application/json');
    console.log(headers);

    this.httpClient.post<Enrollment>('http://localhost:8080/enrollment/enroll', toEnroll, {headers : headers}).subscribe(
      data => {
        this.courses.push(data as Enrollment);
      },
      err => {
        console.log("Error occured");
      },
    );
    
    this.courseId = '';
    this.itemCount = this.courses.length;
  }

  updateInfo() {
    var info = JSON.stringify({id:this.userId, name:this.name, address:this.address, email:this.email});
    console.log(info);
    let headers = new HttpHeaders();
    headers.set('Accept', 'application/json').set('Content-Type', 'application/json');
    console.log(headers);

    this.httpClient.post('http://localhost:8080/student/update', info, {headers : headers}).subscribe(
      err => {
        console.log("Error occured");
      },
    );

    this.name = '';
    this.address = '';
    this.email = '';
  }

  removeItem(i) {
    this.courses.splice(i, 1);
    this.itemCount = this.courses.length;
  }

  navigatorFc() {
    this.router.navigate(['uri']);
  }

}
