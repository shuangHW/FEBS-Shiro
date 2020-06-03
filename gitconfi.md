
###
1 $ ssh-keygen -t rsa -f ~/.ssh/id_rsa_shuangHW -C "alllove1205mine@sina.com"
2 $ ssh-keygen -t rsa -f ~/.ssh/id_rsa_shuangw -C "814666153@qq.com"
3 $ ssh-agent bash
4 $ ssh-add ~/.ssh/id_rsa_shuangHW
5 $ ssh-add ~/.ssh/id_rsa_shuangw
6 ? $ echo "ssh-add ~/.ssh/id_rsa_shuangHW >/dev/null 2&1" >> ~/.bashrc
7 ? $ echo "ssh-add ~/.ssh/id_rsa_shuangw >/dev/null 2&1" >> ~/.bashrc
8 $ git config --global --unset user.name && git config --global --unset user.email


###
# gitee
Host gitee.com
HostName gitee.com
User 814666153@qq.com
Port 22
PreferredAuthentications publickey
IdentityFile ~/.ssh/id_rsa_shuangw

# github
Host github.com
Hostname ssh.github.com
User alllove1205mine@sina.com
Port 443
PreferredAuthentications publickey
IdentityFile ~/.ssh/id_rsa_shuangHW

###
$ ssh -vT git@github.com

###
$ git config --local user.name "shuangHW"
$ git config --local user.email "alllove1205mine@sina.com"
$ git pull origin dev
$ git add .
$ git commit -m 'test duplicate git'
$ git push origin dev

