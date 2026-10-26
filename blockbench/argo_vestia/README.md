# Argo Vestia

Modelo-fonte da nova Argo Vestia criado no Blockbench 5.2.2 para o VOID POWER.

## Arquivos

- `argo_vestia.bbmodel`: projeto editável do Blockbench no formato livre.
- `argo_vestia.png`: atlas de textura RGBA em 256×256.
- `argo_vestia.obj`: exportação de malha para integração futura.
- `argo_vestia.mtl`: material do OBJ, apontando para a textura PNG.
- `previews/`: vistas frontal e em perspectiva para aprovação visual.

## Estrutura

O projeto possui quatro grupos editáveis:

1. `01_Cabo_Curvo`: cabo longo, segmentado e levemente curvado, com anéis, espinhos e cristais.
2. `02_Cranio_Abissal`: cabeça de criatura com bico, maxilar, coroa óssea, órbita e olho do vazio.
3. `03_Lamina_Dimensional`: lâmina principal ampla, curva e afastada do cabo.
4. `04_Energia_e_Cristais`: fio violeta, veios de energia e cristais luminosos.

## Otimização

- 39 elementos de malha.
- 636 vértices.
- 568 faces exportadas.
- Um único atlas de textura 256×256.
- Sem subdivisões excessivas ou texturas de alta resolução.
- Detalhes pequenos representados principalmente pela textura e por malhas simples.

## Como abrir

Abra `argo_vestia.bbmodel` no Blockbench. A textura está incorporada ao projeto e também disponível separadamente como `argo_vestia.png`.

Este modelo ainda não está registrado como item no Minecraft; essa integração pertence à Etapa 4.
