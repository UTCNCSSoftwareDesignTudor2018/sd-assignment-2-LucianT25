import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  itemCount : number;
  btnText : string = "Enroll";
  courseId : string = "";
  courses = [];
  coursesResponse;
  userId : number;

  constructor(private route: ActivatedRoute, private router : Router, private httpClient : HttpClient) {
    this.route.params.subscribe(res => this.userId = res.id);
    console.log(this.userId);
   }

  ngOnInit() {
    this.itemCount = this.courses.length;
    this.httpClient.get('http://192.168.100.11:8080/enrollment/getStudentEnrollments?studentId='+this.userId).subscribe(data => { this.coursesResponse = data},
          err => console.error(err),
          () => console.log('done loading courses')
        );

  }

  addItem() {
    this.courses.push(this.courseId);
    this.courseId = '';
    this.itemCount = this.courses.length;
  }

  removeItem(i) {
    this.courses.splice(i, 1);
    this.itemCount = this.courses.length;
  }

  navigatorFc() {
    this.router.navigate(['uri']);
  }

}
