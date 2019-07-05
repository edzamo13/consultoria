
import { Component, OnInit, Injectable } from '@angular/core';
import { FlatTreeControl } from '@angular/cdk/tree';
import { MatTreeFlatDataSource, MatTreeFlattener } from '@angular/material/tree';
import { ActivatedRoute, Router } from '@angular/router';


export interface Link {
  name: string;
  url: string;
  icono: string;
}




@Component({
  selector: 'app-left-menu',
  templateUrl: './left-menu.component.html',
  styleUrls: ['./left-menu.component.css']
})
export class LeftMenuComponent implements OnInit {
  links: Link[] = [{
    name: 'SETEC',
    url: 'http://www.setec.gob.ec/',
    icono: 'fas fa-door-open'
  },
  {
    name: 'Capacitador Independiente',
    url: 'http://portal.setec.gob.ec/setec-capacitadores-independientes-web/login.jsf',
    icono: 'fas fa-chalkboard-teacher'
  }
  ];




  constructor(

  ) {


  }







  ngOnInit() {



  }

}
