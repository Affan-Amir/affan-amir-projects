import discord
import random
import asyncio
from googletrans import Translator
import googletrans
from discord.ext import commands
from Embeds import *

token = 'ODM1MzQ1NTQ4MjAxNjg5MTA4.YIOGKg.Al5u690ix6W8m7gb6A_dPrpd83U'
prefix = '!'

bot = commands.Bot(command_prefix = prefix)
embeds = Embeds()

@bot.event
async def on_ready():
    print("Student Resources bot now running.")

@bot.event
async def on_message(ctx):
    try:
        if ctx.mentions[0] == bot.user:
            await ctx.channel.send("The prefix for this server is: " + prefix + "\nFor a list of commands, type " + prefix + "srhelp`")
    except:
        pass
    await bot.process_commands(ctx)

@bot.command()
async def timer(ctx, number:int):
    try:
        num = number
        if number < 0:
            await ctx.send('Number cant be a negative')
        elif number > 300:
            await ctx.send('Number must be under 300')
        else:
            message = await ctx.send(embed = embeds.timerEmbed(num, number))
                                     
            while number != 0:
                number -= 1
                await message.edit(embed = embeds.timerEmbed(num, number))
                await asyncio.sleep(1)
            await message.edit(embed = embeds.timerEmbed(num, number))
            await ctx.send('Timer finished {}!'.format(ctx.message.author.mention))

    except:
        await ctx.send('Time was not a number')

@bot.command()
async def cylinderVolume(ctx, radius:int, height:int):
    await ctx.send(math.pi*(radius**2)*height)

@bot.command()
async def rootFinder(ctx, a:int, b:int, c:int):
    r = b**2 - 4*a*c

    if (r > 0):
        num_roots = 2
        x1 = (((-b) + sqrt(r))/(2*a))
        x2 = (((-b) - sqrt(r))/(2*a))
        await ctx.send('The roots are: {} and {}'.format(x1, x2))

    elif (r == 0):
        num_roots = 1
        x = (-b) /(2*a)
        await ctx.send('There is only one root: {}'.format(x))

    else:
        num_roots = 0
        await ctx.send('No roots.')

@bot.command()
async def translate_text(ctx, translated_language, *text):
    text = " ".join(text)
    translator = Translator()
    supported_languages = list(googletrans.LANGUAGES.keys())
    if translated_language not in supported_languages:
        await ctx.send("The language you selected is not supported.")
    else:
        translation = translator.translate(text, dest=translated_language)
        await ctx.send("**Translation:**\n" + translation.text)

@bot.command()
async def translate_list(ctx):
    await ctx.send("__**List of supported languages**__\naf: afrikaans\nsq: albanian\nam: amharic\nar: arabic\nhy: armenian\naz: azerbaijani\neu: basque\nbe: belarusian\nbn: bengali\nbs: bosnian\nbg: bulgarian\nca: catalan\nceb: cebuano\nny: chichewa\nzh-cn: chinese (simplified)\nzh-tw: chinese (traditional)\nco: corsican\nhr: croatian\ncs: czech\nda: danish\nnl: dutch\nen: english\neo: esperanto\net: estonian\ntl: filipino\nfi: finnish\nfr: french\nfy: frisian\ngl: galician\nka: georgian\nde: german\nel: greek\ngu: gujarati\nht: haitian creole\nha: hausa\nhaw: hawaiian\niw: hebrew\nhe: hebrew\nhi: hindi\nhmn: hmong\nhu: hungarian\nis: icelandic\nig: igbo\nid: indonesian\nga: irish\nit: italian\nja: japanese\njw: javanese\nkn: kannada\nkk: kazakh\nkm: khmer\nko: korean\nku: kurdish (kurmanji)\nky: kyrgyz\nlo: lao\nla: latin\nlv: latvian\nlt: lithuanian\nlb: luxembourgish\nmk: macedonian\nmg: malagasy\nms: malay\nml: malayalam\nmt: maltese\nmi: maori\nmr: marathi\nmn: mongolian\nmy: myanmar (burmese)\nne: nepali\nno: norwegian\nor: odia\nps: pashto\nfa: persian\npl: polish\npt: portuguese\npa: punjabi\nro: romanian\nru: russian\nsm: samoan\ngd: scots gaelic\nsr: serbian\nst: sesotho\nsn: shona\nsd: sindhi\nsi: sinhala\nsk: slovak\nsl: slovenian\nso: somali\nes: spanish\nsu: sundanese\nsw: swahili\nsv: swedish\ntg: tajik\nta: tamil\nte: telugu\nth: thai\ntr: turkish\nuk: ukrainian\nur: urdu\nug: uyghur\nuz: uzbek\nvi: vietnamese\ncy: welsh\nxh: xhosa\nyi: yiddish\nyo: yoruba\nzu: zulu\n")

@bot.command()
async def create_citation(ctx, arg, arg1, arg2, arg3, arg4, arg5):
    await ctx.send(embed = embeds.citation_embed(arg, arg1, arg2, arg3, arg4, arg5))

@bot.command()
async def ptable(msg):
    await msg.send(embed = embeds.ptable)

@bot.command()
async def gr11math_help(msg, arg=None, arg2=None):
    if arg == "functions":
        await msg.send(embed = embeds.functions1)
        await msg.send(embed = embeds.functions2)
    if arg == "trig" or arg == "trigonometry":
        await msg.send(embed = embeds.trigonometry)
    if arg == "exponential":
        await msg.send(embed = embeds.exponential1)
        await msg.send(embed = embeds.exponential2)
    if arg == "finance":
        await msg.send(embed = embeds.finance1)
        await msg.send(embed = embeds.finance2)
        await msg.send(embed = embeds.finance3)
        await msg.send(embed = embeds.finance4)
        await msg.send(embed = embeds.finance5)
        await msg.send(embed = embeds.finance6)
        await msg.send(embed = embeds.finance7)
        await msg.send(embed = embeds.finance8)
        await msg.send(embed = embeds.finance9)
    if arg == None:
        await msg.send("Invalid Command! Please enter `/help` to see a list of commands.")

@bot.command()
async def srhelp(msg, arg=1):
    if arg == 1:
        await msg.send(embed = embeds.help1)
    elif arg == 2:
        await msg.send(embed = embeds.help2)

@bot.command(aliases = ['inspiration', 'inspireme'])
async def inspire(msg):
    responses = ['Never give up',
                 'Be grateful',
                 'Character > reputation',
                 'You got this',
                 'Be a boss',
                 'Almost there',
                 'Remember to be cool']
    await msg.send(f'{random.choice(responses)}')

bot.run(token)
