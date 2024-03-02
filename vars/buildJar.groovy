#!/usr/bin/env groovy

def call() {
    def branchName = env.BRANCH_NAME ?: env.GIT_BRANCH
    echo "Building application jar for branch: ${branchName}"

    // 原来$BRANCH_NAME是用于multi-branch，如果Pipeline不是在 Multibranch Pipeline 或者基于分支的构建中运行，那么 BRANCH_NAME 变量可能没有被设置。
    // 在这种情况下，使用其他方式获取分支信息，例如通过 Git 插件的 GIT_BRANCH 环境变量，如上
    // echo "building the application for branch $BRANCH_NAME"
    sh 'mvn package'
}
