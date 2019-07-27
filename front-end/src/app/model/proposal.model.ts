export class Proposal{
    constructor(
        public name: string,
        public cpf: string,
        public sex: string,
        public age: string,
        public maritalStatus: string,
        public dependents: number,
        public income: number,
    ) {}
}