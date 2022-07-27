import axios from 'axios';
import React, { useState } from 'react';
import { Button, Checkbox, Form } from 'semantic-ui-react';
import { BASE_URL } from '../utils/request';

export default function Create() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [cpf, setCpf] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const [checkbox, setCheckbox] = useState(false);

    const postData = () => {
        axios.post(`${BASE_URL}/usuarios/salvar`, {
            nome,
            email,
            cpf,
            dataNascimento
        })
    }
    return (
        <div>
            <Form className="create-form">
                <Form.Field>
                    <label>Nome</label>
                    <input placeholder='Nome' onChange={(e) => setNome(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>E-mail</label>
                    <input placeholder='Email' onChange={(e) => setEmail(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>CPF</label>
                    <input placeholder='cpf' onChange={(e) => setCpf(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>Data de Nascimento</label>
                    <input placeholder='Data de Nascimento' onChange={(e) => setDataNascimento(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                <Checkbox label='I agree to the Terms and Conditions' onChange={(e) => setCheckbox(!checkbox)}/>
                </Form.Field>
                <Button onClick={postData} type='submit'>Submit</Button>
            </Form>
        </div>
    )
}