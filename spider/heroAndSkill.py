import requests
import os

def start():
  url = 'https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js'
  headers = {
      "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36",
      "referer": "https://lol.qq.com/"
  }

  response = requests.get(url, headers=headers)

  heroList = response.json()['hero']
  print("开始下载")

  for i in range(1, len(heroList) + 1):
    try:
      heroUrl = f"https://game.gtimg.cn/images/lol/act/img/js/hero/{i}.js"
      heroResponse = requests.get(heroUrl, headers=headers)
      data = heroResponse.json()

      downloadPng(data)

    except Exception as e:
      print("下载失败")
      print(i)

  print("下载完成")


def downloadPng(data):
  try:
    hero = data['hero']
    spells = data['spells']
    name = hero['name']
    alias = hero['alias']

    print(f"正在下载{name}的图片")

    url = "https://game.gtimg.cn/images/lol/act/img/champion/"+ alias +".png"
    response = requests.get(url)

    dir = f"E:\\java\\test_img\\hero\\{name}"
    heroPath = f"{dir}\\{name}.png"

    if not os.path.exists(dir):
      os.makedirs(dir)

    with open(heroPath, "wb") as f:
      f.write(response.content)

    for spell in spells:
      abilityIconPath = spell['abilityIconPath']
      spellName = spell['name']
      spellDir = f"{dir}\\spells"
      spellPath = f"{spellDir}\\{spellName}.png"

      print(f"正在下载{name}的技能{spellName}的图片")

      response = requests.get(abilityIconPath)

      if not os.path.exists(spellDir):
        os.makedirs(spellDir)

      with open(spellPath, "wb") as f:
        f.write(response.content)

  except Exception as e:
    print(f"下载{name}的图片失败")


if __name__ == '__main__':
    start()

