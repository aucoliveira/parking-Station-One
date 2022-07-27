import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Button, Form } from 'semantic-ui-react'
import { BASE_URL } from '../utils/request';

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';


export default function CreateVehicle() {
    const [marca, setMarca] = useState('');
    const [modelo, setModelo] = useState('');
    const [ano, setAno] = useState('');
    const [user, setUser] = useState('');

    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [cpf, setCpf] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');

    const [id, setID] = useState('');

    useEffect(() => {
        setID(localStorage.getItem('id'))
        setNome(localStorage.getItem('nome'));
        setEmail(localStorage.getItem('email'));
        setCpf(localStorage.getItem('cpf'))
        setDataNascimento(localStorage.getItem('dataNascimento'))
    }, []);

    const postData = () => {
        axios.post(`${BASE_URL}/veiculos/salvar`, {
            marca,
            modelo,
            ano,
            user: {
                id
            }


        }).then(response => {
            console.log(response)
            return response.json()
        })
            .catch(error => {
                console.log(error.response)
            })
    }
    return (
        <div>
            <Form className="create-form">
                <Form.Field>
                    <label>Marca</label>
                    <input placeholder='Nome' onChange={(e) => setMarca(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>Modelo</label>
                    <input placeholder='modelo' onChange={(e) => setModelo(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>Ano</label>
                    <input placeholder='ano' onChange={(e) => setAno(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>Nome do usuário</label>
                    <input placeholder='Nome usuário' value={nome} onChange={(e) => setNome(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>Email</label>
                    <input placeholder='email' value={email} onChange={(e) => setEmail(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>CPF</label>
                    <input placeholder='Cpf' value={cpf} onChange={(e) => setCpf(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label>Data Nascimento</label>
                    <input placeholder='data nascimento' value={dataNascimento} onChange={(e) => setDataNascimento(e.target.value)} />
                </Form.Field>
                <Button onClick={postData} type='submit'>Submit</Button>
            </Form>
        </div>
    )
}