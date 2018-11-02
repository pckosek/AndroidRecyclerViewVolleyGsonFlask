#!/bin/bash

source venv/bin/activate
gunicorn server:app -b 127.0.0.1:$PORT -w=1