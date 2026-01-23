from typing import Union
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from models.models import db, Jogo
from models.json import JsonJogoAtualizar
from sqlalchemy import select

app = FastAPI()

origins = [
    "http://localhost:3000"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
def read_index():
    return {"API Operante"}

@app.get("/get/{jogo_id}")
async def get_jogo_info(jogo_id):
    info = db.get(Jogo, jogo_id)
    return({"jogo": info})

@app.get("/get/jogos")
def get_jogos():
    jogos = []
    for jogo in db.scalars(select(Jogo)):
        jogos.append(jogo)
    
    return({"jogos": jogos})

@app.post("/update/jogo")
async def update_jogo(json: JsonJogoAtualizar):
    jogo = db.get(Jogo, json.id)

    if json.nome != jogo.nome:
        jogo.nome = json.nome
    if json.status != jogo.status:
        jogo.status = json.status

    db.commit()



