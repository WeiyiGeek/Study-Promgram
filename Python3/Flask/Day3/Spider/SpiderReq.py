# coding: utf-8
import requests
from pprint import pprint 

def get_data():
  response = requests.get('http://127.0.0.1:8000/get/info')
  pprint(response.content.decode('utf-8')) #pip install pprint

if __name__ == "__main__":
  get_data()