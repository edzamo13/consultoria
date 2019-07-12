import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portal-main-carrusel',
  templateUrl: './portal-main-carrusel.component.html',
  styleUrls: ['./portal-main-carrusel.component.scss']
})
export class PortalMainCarruselComponent implements OnInit {

  event_list = [
    {
      event: ' Event 1',
      eventLocation: 'Bangalore',
      eventDescription: 'In bangalore, first event is going to happen. Please be careful about it',
      img: 'https://picsum.photos/900/500?random&t=1',
      eventStartDate: new Date('2019/05/20'),
      eventEndingDate: new Date('2019/05/24'),
      servicio: 'Catálogo Nacional de Cualificaciones para Operadores de Capacitación',
      tipoServicio: 'CNC',
      logo: 'maletin_2_24px',
      leyenda: 'Contiene todas las cualificaciones profesionales de significancia para el sector ' +
        'productivo y sobre las cuales los Operadores de Capacitación calificados por la SETEC pueden capacitar.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 2',
      eventLocation: 'Dubai',
      eventDescription: 'Dubai is another place to host so,e, first event is going to happen. Please be careful about it',
      img: 'https://picsum.photos/900/500?random&t=3',
      eventStartDate: new Date('2019/07/28'),
      eventEndingDate: new Date('2019/07/30'),
      servicio: 'Operadores de Capacitación',
      tipoServicio: 'OC',
      logo: 'birrete_2_24px',
      leyenda: 'Si estás interesado en capacitarte, en esta sección podrás encontrar a todos los Operadores ' +
        'de Capacitación calificados por la SETEC a nivel nacional. Puedes buscar la información por ubicación geográfica,' +
        ' oferta en capacitación continua/competencias laborales o nombre de la institución y comunicarte directamente con ellos.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 3',
      eventLocation: 'New York',
      eventDescription: 'NewYork sits on top of event hosting',
      img: 'https://picsum.photos/900/500?random&t=4',
      eventStartDate: new Date('2020/05/20'),
      eventEndingDate: new Date('2020/05/24'),
      servicio: 'Personas Capacitadas por Operadores de Capacitación',
      tipoServicio: 'OC',
      logo: 'sociologia_2_24px',
      leyenda: 'Si estás interesado en conocer las personas capacitadas, en esta sección podrás encontrar la ' +
        'validación de todas las personas capacitadas por nuestros Operadores de Capacitación calificados por la SETEC a nivel nacional.' +
        ' Puedes buscar la información por número de cédula, nombres y/o apellidos y por el nombre del curso.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 4',
      eventLocation: 'Singapore',
      eventDescription: 'Singapore is another great hosting city',
      img: 'https://picsum.photos/900/500?random&t=6',
      eventStartDate: new Date('2018/05/20'),
      eventEndingDate: new Date('2018/05/24'),
      servicio: 'Organismos Evaluadores de la Conformidad',
      tipoServicio: 'OEC',
      logo: 'universidad_2_24px',
      leyenda: 'Si estás interesado en certificar tu experiencia, en esta sección podrás encontrar a todos los Organismos Evaluadores ' +
        'de la Conformidad reconocidos por la SETEC a nivel nacional. Puedes buscar la información por ubicación geográfica, ' +
        'perfil o nombre de la institución y comunicarte directamente con ellos.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 5',
      eventLocation: 'Berlin',
      eventDescription: 'Berlin is best place to hang on',
      img: 'https://picsum.photos/900/500?random&t=7',
      eventStartDate: new Date('2017/07/10'),
      eventEndingDate: new Date('2017/08/14'),
      servicio: 'Personas Certificadas',
      tipoServicio: 'OEC',
      logo: 'estudiante_2_24px',
      leyenda: 'Si estás interesado en contratar personas que cuenten con Certificación por Competencias Laborales, aquí podrás encontrar' +
        ' la validación de todos los ciudadanos certificados a nivel nacional. Puedes buscar la información por perfil, número de cédula,' +
        ' nombres y/o apellidos y comunicarte directamente con ellos.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 6',
      eventLocation: 'Mumbai',
      eventDescription: 'Mumbai is hub of startups',
      img: 'https://picsum.photos/900/500?random&t=8',
      eventStartDate: new Date(),
      eventEndingDate: new Date(),
      servicio: 'Capacitadores Independientes',
      tipoServicio: 'CI',
      logo: 'profesor_2_24px',
      leyenda: 'Si estás interesado en capacitarte, en esta sección podrás encontrar a todos los Capacitadores Independientes calificados' +
        ' por la SETEC a nivel nacional. Puedes buscar la información por número de cédula y/o apellidos y comunicarte directamente ' +
        'con ellos.',
      url: 'www.google.com',
      refUrl: ''
    },
    {
      event: ' Event 7',
      eventLocation: 'Barcelona',
      eventDescription: 'Barcelona is another good city',
      img: 'https://picsum.photos/900/500?random&t=6',
      eventStartDate: new Date(),
      eventEndingDate: new Date(),
      servicio: 'Personas Capacitadas por Capacitadores Independientes',
      tipoServicio: 'CI',
      logo: 'presentacion_2_24px',
      leyenda: 'Si estás interesado en conocer las personas capacitadas, en esta sección podrás encontrar la validación de todas las ' +
        'personas capacitadas por nuestros Capacitadores Independientes calificados por la SETEC a nivel nacional. Puedes buscar la ' +
        'información por número de cédula, nombres y/o apellidos y por el nombre del curso.',
      url: 'www.google.com',
      refUrl: ''
    },
  ]

  upcoming_events = this.event_list
  //upcoming_events = this.event_list.filter(event => event.eventStartDate > new Date());
  // past_events = this.event_list.filter(event => event.eventEndingDate < new Date());
  //current_events = this.event_list.filter(event => (event.eventStartDate >= new Date() && (event.eventEndingDate <= new Date())))
  constructor() {
  }

  ngOnInit() {
  }


}
