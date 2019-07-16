export class ResponseProposta{
    constructor(
        public cpf: string,
        public status: string,
        public margin: string,
        public descriptionResult: string
    ){}
}