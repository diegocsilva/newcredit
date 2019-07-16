import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ProposalService } from 'src/app/services/proposal/proposal.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Proposal } from '../../model/proposal.model';

@Component({
  selector: 'app-proposal-new',
  templateUrl: './proposal-new.component.html',
  styleUrls: ['./proposal-new.component.css']
})
export class ProposalNewComponent implements OnInit {
  myForm: FormGroup;
  
  proposal: Proposal;

  constructor(
    private toastr: ToastrService,
    private proposalService: ProposalService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.initForm();
  }

  initForm(): void {
    this.myForm = new FormGroup({
      
        });
  }

  send() {
    if (this.validForm()) {
      this.proposalService.create(this.proposal).subscribe(
        (response: any) => {
          this.myForm.reset();
          this.router.navigate(['proposal']);
        },
        err => {
          const httpError: HttpErrorResponse = err;
          this.toastr.error(httpError.error['error']);
        }
      );
    }
  }

  validForm(): boolean {
    let valid = true;
    return valid;
  }

  resetForm(): void {
    this.myForm.patchValue({
    });
  }
  cancel() {
    this.resetForm();
    this.toastr.info('Filtros limpos com sucesso!');
  }
}
