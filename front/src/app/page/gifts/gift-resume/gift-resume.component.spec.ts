import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GiftResumeComponent } from './gift-resume.component';

describe('GiftResumeComponent', () => {
  let component: GiftResumeComponent;
  let fixture: ComponentFixture<GiftResumeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GiftResumeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GiftResumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
