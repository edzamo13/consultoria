import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortalMainCarruselComponent } from './portal-main-carrusel.component';

describe('PortalMainCarruselComponent', () => {
  let component: PortalMainCarruselComponent;
  let fixture: ComponentFixture<PortalMainCarruselComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortalMainCarruselComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortalMainCarruselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
