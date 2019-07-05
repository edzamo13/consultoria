import { Component, AfterContentInit, ContentChildren, ViewChild, QueryList, ElementRef } from '@angular/core';
import { SliderItemDirective } from './slider-item.directive';

@Component({
  selector: 'app-portal-main-carrusel',
  templateUrl: './portal-main-carrusel.component.html',
  styleUrls: ['./portal-main-carrusel.component.scss']
})
export class PortalMainCarruselComponent implements AfterContentInit  {


  @ContentChildren(SliderItemDirective, { read: ElementRef }) items
    : QueryList<ElementRef<HTMLDivElement>>; 
  @ViewChild('slides',{ static: true }) slidesContainer: ElementRef<HTMLDivElement>;

  private slidesIndex = 0;

  get currentItem(): ElementRef<HTMLDivElement> {
    return this.items.find((item, index) => index === this.slidesIndex);
  }

  ngAfterContentInit() {
    console.log('items', this.items);
  }

  ngAfterViewInit() {
    console.log('slides', this.slidesContainer); 
  }

  onClickLeft() {
    this.slidesContainer.nativeElement.scrollLeft -= this.currentItem.nativeElement.offsetWidth;
    
    if (this.slidesIndex > 0) {
      this.slidesIndex--;
    } 
  }

  onClickRight() {
    this.slidesContainer.nativeElement.scrollLeft += this.currentItem.nativeElement.offsetWidth;

    if (this.slidesIndex < this.items.length - 1) {
      this.slidesIndex++
    }
  }


}
