from pydantic import BaseModel

class JsonJogoAtualizar(BaseModel):
    id: int
    nome: str
    status: str