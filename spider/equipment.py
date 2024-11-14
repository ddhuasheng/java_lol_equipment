import requests
import os

def start():
    url = 'https://game.gtimg.cn/images/lol/act/img/js/items/items.js'

    headers = {
      "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36",
      "referer": "https://lol.qq.com/"
    }

    response = requests.get(url, headers=headers)

    data = response.json()

    for item in data['items']:
        name = item['name']
        iconPath = item['iconPath']
        equipmentDir = f"E:\\java\\test_img\\Equipment"
        equipmentUrl = f"{equipmentDir}\\{name}.png"

        if not os.path.exists(equipmentDir):
            os.makedirs(equipmentDir)

        try:
            print(f"Downloading {name}...")
            with open(equipmentUrl, 'wb') as f:
                f.write(requests.get(iconPath).content)
        except Exception as e:
            print(f"Error downloading {name}: {e}")

if __name__ == '__main__':
    start()